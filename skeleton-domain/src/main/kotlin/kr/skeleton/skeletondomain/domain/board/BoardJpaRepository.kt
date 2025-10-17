package kr.skeleton.skeletondomain.domain.board

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class BoardJpaRepository :
    QuerydslRepositorySupport(Board::class.java),
    BoardRepository {
    override fun save(board: Board) {
        entityManager!!.persist(board)
    }
}
