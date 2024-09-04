package br.org.acal.domain.entity

data class Customer(
    val number: String,
    val name: String,
    val document: Document,
    val partner: Partner
)