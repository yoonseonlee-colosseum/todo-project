package kr.skeleton.skeletonapi.domain.board.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import kr.skeleton.skeletonapi.domain.board.payload.CreateBoardApiRequest
import kr.skeleton.skeletondomain.usecase.board.CreateBoardRequest
import kr.skeleton.skeletondomain.usecase.board.CreateBoardUseCase

@RestController
class BoardController(private val createBoardUseCase: CreateBoardUseCase) {
    @PostMapping("/api/boards")
    fun createBoard(@RequestBody request: CreateBoardApiRequest) {
        createBoardUseCase.create(
            CreateBoardRequest(
                title = request.title,
                content = request.contents,
            ),
        )
    }
}
