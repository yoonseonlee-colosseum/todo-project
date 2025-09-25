package kr.skeleton.skeletoninfra.payload

import org.apache.poi.ss.usermodel.HorizontalAlignment

import com.colosseum.excel.annotation.ExcelBodyStyle
import com.colosseum.excel.annotation.ExcelColumn
import com.colosseum.excel.annotation.ExcelFileName
import com.colosseum.excel.annotation.ExcelHeaderStyle
import com.colosseum.excel.annotation.ExcelMergedColumn

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
