package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.FileRequest
import ua.kpi.its.lab.rest.dto.FileResponse
import ua.kpi.its.lab.rest.entity.StorageFile
import ua.kpi.its.lab.rest.repository.FileRepository
import ua.kpi.its.lab.rest.svc.FileService
@Service
class FileServiceImpl(private val fileRepository: FileRepository) : FileService {
    override fun createFile(fileRequest: FileRequest): FileResponse {
        val storageFile = StorageFile(name = fileRequest.name, extension = fileRequest.extension)
        val newFile = fileRepository.save(storageFile)
        return FileResponse.fromEntity(newFile)
    }

    override fun getFileById(id: Long): FileResponse {
        val file = fileRepository.findById(id).orElseThrow()
        return FileResponse.fromEntity(file)
    }

    override fun updateFileById(id: Long, fileRequest: FileRequest): FileResponse {
        val file = fileRepository.findById(id).orElseThrow()
        file.name = fileRequest.name
        file.extension = fileRequest.extension
        val updFile = fileRepository.save(file)
        return FileResponse.fromEntity(updFile)
    }

    override fun deleteFileById(id: Long): Boolean {
        fileRepository.deleteById(id)
        return true
    }
}