package br.org.acal.resources.adapter

import br.org.acal.domain.entity.Customer
import br.org.acal.domain.entity.Document
import br.org.acal.domain.entity.Partner
import br.org.acal.resources.model.CustomerModel

class CustomerAdapter {
    fun map(customerModel: CustomerModel): Customer {

        val type = customerModel.cpf?.let { "CPF" } ?: "CNPJ"
        val number = customerModel.cpf?.let { "CPF" } ?: "CNPJ"

        return Customer(
            number = customerModel.number,
            name = "${customerModel.name.trim()} ${customerModel.lastName?.trim()}",
            document = Document(type, number),
            partner = Partner(customerModel.partner)
        )
    }

    fun map(customer: Customer): CustomerModel {
        return when (customer.document.type){
            "CPF" -> CustomerModel(name = customer.name, number = customer.number, cpf = customer.document.number)
            else -> CustomerModel(name = customer.name, number = customer.number, cnpj = customer.document.number)
        }
    }
}
