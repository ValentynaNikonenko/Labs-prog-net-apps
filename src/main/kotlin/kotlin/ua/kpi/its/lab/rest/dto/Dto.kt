package ua.kpi.its.lab.rest.dto

class FileRequest {
    var name: String? = null
        private set
    var extension: String? = null
        private set
    var size: Double? = null
        private set

    constructor()
    constructor(name: String?, extension: String?, size: Double?) {
        this.name = name
        this.extension = extension
        this.size = size
    }
}


class FileResponse {
    var id: Long? = null
        private set
    var name: String? = null
        private set
    var extension: String? = null
        private set
    var size: Double? = null
        private set

    constructor()
    constructor(id: Long?, name: String?, extension: String?, size: Double?) {
        this.id = id
        this.name = name
        this.extension = extension
        this.size = size
    }
}


class PhoneRequest {
    var brand: String? = null
        private set
    var manufacturer: String? = null
        private set
    var model: String? = null
        private set

    constructor()
    constructor(brand: String?, manufacturer: String?, model: String?) {
        this.brand = brand
        this.manufacturer = manufacturer
        this.model = model
    }
}


class PhoneResponse {
    var id: Long? = null
        private set
    var brand: String? = null
        private set
    var manufacturer: String? = null
        private set
    var model: String? = null
        private set

    constructor()
    constructor(id: Long?, brand: String?, manufacturer: String?, model: String?) {
        this.id = id
        this.brand = brand
        this.manufacturer = manufacturer
        this.model = model
    }
}

