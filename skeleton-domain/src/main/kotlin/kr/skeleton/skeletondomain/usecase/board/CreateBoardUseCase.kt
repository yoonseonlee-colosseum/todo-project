package kr.skeleton.skeletondomain.usecase.board

interface CreateBoardUseCase {
    fun create(request: CreateBoardRequest)
}

data class CreateBoardRequest(val title: String, val content: String)
