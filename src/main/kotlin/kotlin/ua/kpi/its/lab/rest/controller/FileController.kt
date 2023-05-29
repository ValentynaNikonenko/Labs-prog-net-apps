package ua.kpi.its.lab.rest.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.FileRequest
import ua.kpi.its.lab.rest.dto.FileResponse
import ua.kpi.its.lab.rest.svc.impl.FileServiceImpl

@RestController
@RequestMapping("/file")
class FileController(private val fileService: FileServiceImpl) {
    @PostMapping
    fun createFile(@RequestBody req: FileRequest): ResponseEntity<FileResponse> {
        val response = fileService.createFile(req)
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getFileById(@PathVariable id: Long): ResponseEntity<FileResponse> {
        val response = fileService.getFileById(id)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateFileById(@PathVariable id: Long, @RequestBody req: FileRequest): ResponseEntity<FileResponse> {
        val response = fileService.updateFileById(id, req)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteFileById(@PathVariable id: Long): ResponseEntity<Void> {
        fileService.deleteFileById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}