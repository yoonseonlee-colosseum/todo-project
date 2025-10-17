package kr.skeleton.skeletondomain

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity(regMid: String?, modMid: String?) : BaseTimeEntity() {
    constructor() : this(
        regMid = DEFAULT_MID,
        modMid = DEFAULT_MID,
    )

    @CreatedBy
    @Column(name = "reg_mid", updatable = false)
    var regMid: String? = regMid
        protected set

    @LastModifiedBy
    @Column(name = "mod_mid")
    var modMid: String? = modMid
        protected set

    companion object {
        const val DEFAULT_MID = "USER"
    }
}
