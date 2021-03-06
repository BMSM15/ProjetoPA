package com.example.projetopa

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteQuery
import android.database.sqlite.SQLiteQueryBuilder
import android.provider.BaseColumns

class TabelaBDJogador(db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_NOME TEXT NOT NULL, $CAMPO_DINHEIRO TEXT NOT NULL)")
    }

    companion object {
        const val NOME = "Jogadores"
        const val CAMPO_ID = "$NOME.${BaseColumns._ID}"
        const val CAMPO_NOME = "Usuario"
        const val CAMPO_DINHEIRO = "Dinheiro"

        val TODAS_COLUNAS = arrayOf(CAMPO_ID, CAMPO_NOME, CAMPO_DINHEIRO)
    }
}