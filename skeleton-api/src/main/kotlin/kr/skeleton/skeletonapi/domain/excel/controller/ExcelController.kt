package kr.skeleton.skeletonapi.domain.excel.controller

import jakarta.servlet.http.HttpServletResponse

import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import com.colosseum.excel.ColoExcelGenerator
import com.colosseum.excel.annotation.ExcelBodyStyle
import com.colosseum.excel.annotation.ExcelColumn
import com.colosseum.excel.annotation.ExcelFileName
import com.colosseum.excel.annotation.ExcelHeaderStyle
import com.colosseum.excel.annotation.ExcelMergedColumn

@RestController
class ExcelController {
    @GetMapping("/api/test/excel/download")
    fun excelDown(response: HttpServletResponse) {
        val dataList = listOf(TestExcelData(), TestExcelData(), TestExcelData(), TestExcelData(), TestExcelData())

        val toResult = ColoExcelGenerator(
            dataList,
            TestExcelData::class.java,
        ).toResult()

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
        response.setHeader(
            HttpHeaders.CONTENT_DISPOSITION,
            String.format(
                "attachment; filename=\"%s.xlsx\"",
                toResult.fileName,
            ),
        )

        toResult.writeTo(response.outputStream)
    }
}

@ExcelHeaderStyle
@ExcelBodyStyle(alignment = HorizontalAlignment.CENTER)
@ExcelFileName("테스트 엑셀")
private class TestExcelData(

    @ExcelMergedColumn(headerName = "상품명")
    @ExcelColumn(headerName = "상품명(한국어)")
    private val goodsNameKr: String = "상품명(한국어) 내용",

    @ExcelMergedColumn(headerName = "상품명")
    @ExcelColumn(headerName = "상품명(영문)", width = 8000)
    private val goodsNameEng: String = "상품명(영문) 내용",

    @ExcelColumn(headerName = "상품코드", width = 12000)
    private val goodsCode: String = "상품코드 내용",
)
