package kr.skeleton.skeletonapi.domain.board.payload

data class FindBoardApiResponse(
    val boardNo: Int,
    val title: String,
    val actor: String?
)
