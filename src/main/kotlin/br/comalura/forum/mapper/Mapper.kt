package br.comalura.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
