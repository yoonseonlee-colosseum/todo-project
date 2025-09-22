package kr.skeleton.skeletondomain

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.Comment
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseAuditEntity {
	@CreatedBy
	@Column(nullable = false, updatable = false)
	@Comment("생성자")
	var createdBy: String? = null

	@LastModifiedBy
	@Column(nullable = false)
	@Comment("수정자")
	var updatedBy: String? = null
}
