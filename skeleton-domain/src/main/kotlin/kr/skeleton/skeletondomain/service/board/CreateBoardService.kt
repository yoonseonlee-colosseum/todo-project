package kr.skeleton.skeletondomain.service.board

import kr.skeleton.skeletondomain.domain.board.Board
import kr.skeleton.skeletondomain.domain.board.BoardRepository
import kr.skeleton.skeletondomain.usecase.board.CreateBoardRequest
import kr.skeleton.skeletondomain.usecase.board.CreateBoardUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateBoardService(
	private val boardRepository: BoardRepository,
) : CreateBoardUseCase {
	@Transactional
	override fun create(request: CreateBoardRequest) {
		val board =
			Board(
				title = request.title,
				content = request.content,
			)
		boardRepository.save(board)
	}
}
