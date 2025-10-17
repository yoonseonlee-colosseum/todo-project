package kr.skeleton.skeletondomain.domain.board

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

import org.hibernate.annotations.Comment

import kr.skeleton.skeletondomain.BaseEntity

@Entity
@Table(name = "board")
class Board(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Comment("제목")
    @Column(name = "title", length = 100, nullable = false)
    var title: String,

    @Comment("내용")
    @Column(name = "content", nullable = false)
    var content: String,
) : BaseEntity()
