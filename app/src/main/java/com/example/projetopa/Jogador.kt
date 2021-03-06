package com.example.projetopa

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import java.io.Serializable

data class Jogador(
    var Nome_jogador: String,
    var Dinheiro: String,
    var id: Long = -1
) : Serializable {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDJogador.CAMPO_NOME, Nome_jogador)
        valores.put(TabelaBDJogador.CAMPO_DINHEIRO, Dinheiro)

        return valores
    }
    companion object {
        fun fromCursor(cursor: Cursor): Jogador {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posNomeJogador = cursor.getColumnIndex(TabelaBDJogador.CAMPO_NOME)
            val posDinheiro = cursor.getColumnIndex(TabelaBDJogador.CAMPO_DINHEIRO)

            val id = cursor.getLong(posId)
            val Nome_jogador = cursor.getString(posNomeJogador)
            val Dinheiro = cursor.getString(posDinheiro)

            return Jogador(Nome_jogador, Dinheiro, id)
        }
    }
}