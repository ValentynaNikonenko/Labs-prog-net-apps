package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.FileRequest
import ua.kpi.its.lab.rest.dto.FileResponse
interface FileService {
    fun createFile(drugsRequest: FileRequest): FileResponse
    fun getFileById(id: Long): FileResponse
    fun updateFileById(id: Long, drugsRequest: FileRequest): FileResponse
    fun deleteFileById(id: Long): Boolean
}