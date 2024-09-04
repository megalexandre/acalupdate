package br.org.acal.resources.adapter

import br.org.acal.domain.entity.Customer
import br.org.acal.domain.entity.Partner
import br.org.acal.resources.model.CustomerModel
import br.org.acal.resources.model.PartnerModel

class PartnerAdapter {
    fun map(partnerModel: PartnerModel): Partner {
        return Partner(
            number = partnerModel.number,
            memberOnly = partnerModel.memberOnly,
            partnerNumber = partnerModel.partnerNumber
        )
    }

    fun map(partner: Partner, customer: CustomerModel): PartnerModel {
        return PartnerModel(
            number = partner.number,
            memberOnly = partner.memberOnly,
            partnerNumber = partner.partnerNumber,
            customer = customer
        )
    }

}
