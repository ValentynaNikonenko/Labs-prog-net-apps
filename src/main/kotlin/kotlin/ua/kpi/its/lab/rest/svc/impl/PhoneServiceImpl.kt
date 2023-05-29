package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.PhoneRequest
import ua.kpi.its.lab.rest.dto.PhoneResponse
import ua.kpi.its.lab.rest.entity.Phone
import ua.kpi.its.lab.rest.repository.PhoneRepository
import ua.kpi.its.lab.rest.svc.PhoneService

@Service
class PhoneServiceImpl(private val phoneRepository: PhoneRepository) : PhoneService {
    @PreAuthorize("hasAuthority('EDITOR')")
    override fun createPhone(phoneRequest: PhoneRequest): PhoneResponse {
        val phone = Phone(brand = phoneRequest.brand, manufacturer = phoneRequest.manufacturer)
        val newPhone = phoneRepository.save(phone)
        return PhoneResponse.fromEntity(newPhone)
    }

    @PreAuthorize("hasAuthority('VIEWER')")
    override fun getPhoneById(id: Long): PhoneResponse {
        val phone = phoneRepository.findById(id).orElseThrow()
        return PhoneResponse.fromEntity(phone)
    }

    @PreAuthorize("hasAuthority('EDITOR')")
    override fun updatePhoneById(id: Long, phoneRequest: PhoneRequest): PhoneResponse {
        val phone = phoneRepository.findById(id).orElseThrow()
        phone.brand = phoneRequest.brand
        phone.manufacturer = phoneRequest.manufacturer
        val updPhone = phoneRepository.save(phone)
        return PhoneResponse.fromEntity(updPhone)
    }

    @PreAuthorize("hasAuthority('EDITOR')")
    override fun deletePhoneById(id: Long): Boolean {
        phoneRepository.deleteById(id)
        return true
    }
}