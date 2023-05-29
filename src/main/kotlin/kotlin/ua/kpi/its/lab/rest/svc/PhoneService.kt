package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.PhoneRequest
import ua.kpi.its.lab.rest.dto.PhoneResponse

interface PhoneService {
    fun createPhone(phoneRequest: PhoneRequest): PhoneResponse
    fun getPhoneById(id: Long): PhoneResponse
    fun updatePhoneById(id: Long, phoneRequest: PhoneRequest): PhoneResponse
    fun deletePhoneById(id: Long): Boolean
}