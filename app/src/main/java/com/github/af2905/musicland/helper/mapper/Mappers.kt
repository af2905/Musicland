package com.github.af2905.musicland.helper.mapper

open class ListMapper<I, O>(private val mapper: IMapper<I, O>) : IListMapper<I, O> {
    override fun map(input: List<I>): List<O> = input.map { mapper.map(it) }

}

open class NullableInputListMapper<I, O>(private val mapper: IMapper<I, O>) :
    INullableInputListMapper<I, O> {
    override fun map(input: List<I>?): List<O> = input?.map { mapper.map(it) }.orEmpty()

}

open class NullableOutputListMapper<I, O>(private val mapper: IMapper<I, O>) :
    INullableOutputListMapper<I, O> {
    override fun map(input: List<I>): List<O>? =
        if (input.isEmpty()) null else input.map { mapper.map(it) }

}