package ua.kpi.its.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.PhoneRequest
import ua.kpi.its.lab.rest.dto.PhoneResponse
import ua.kpi.its.lab.rest.svc.impl.PhoneServiceImpl


@RestController
@RequestMapping("/api/phone")
class PhoneController {

    private final lateinit var phoneService: PhoneServiceImpl;

    @Autowired
    fun PhoneController(phoneService: PhoneServiceImpl) {
        this.phoneService = phoneService;
    }

    @GetMapping("/{id}")
    fun getPhoneById(@PathVariable Long id): ResponseEntity<PhoneResponse>? {
        val response: PhoneResponse = phoneService.getPhoneById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    fun createPhone(@Valid @RequestBody phoneRequest: PhoneRequest?): ResponseEntity<PhoneResponse>? {
        val response: PhoneResponse? = phoneRequest?.let {
            phoneService.createPhone(it)
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @PutMapping("/{id}")
    fun updatePhoneById(
        @PathVariable id: Long,
        @Valid @RequestBody phoneRequest: PhoneRequest?
    ): ResponseEntity<PhoneResponse>? {
        val response: PhoneResponse? = phoneRequest?.let {
            phoneService.updatePhoneById(id, it)
        }
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{id}")
    fun deletePhoneById(@PathVariable id: Long): ResponseEntity<Void?>? {
        val successful: Boolean = phoneService.deletePhoneById(id)
        if (successful) {
            println("Phone with id $id deleted successfully")
        } else {
            println("Phone with id $id not found")
        }
        return ResponseEntity.noContent().build()
    }
}