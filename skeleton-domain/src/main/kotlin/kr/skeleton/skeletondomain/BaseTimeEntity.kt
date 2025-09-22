package kr.skeleton.skeletondomain

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseTimeEntity {
	@CreationTimestamp
	@Comment("생성일시")
	@Column(nullable = false, updatable = false)
	lateinit var createdAt: Instant

	@UpdateTimestamp
	@Comment("수정일시")
	@Column(nullable = false)
	lateinit var updatedAt: Instant
}
