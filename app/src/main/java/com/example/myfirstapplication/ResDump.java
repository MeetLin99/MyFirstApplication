package com.example.myfirstapplication;

import android.content.Context;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class ResDump {

    private static final String xlsPath = "/home/ca1se/IdeaProjects/";

    private static TreeMap<String, String> infoMap = new TreeMap<>();

    static {
        infoMap.put("5一 / 二 / 三级粒度长度", TestOneActivity.firstGranHalfLength * 2 + "/" + TestOneActivity.secondGranHalfLength * 2 + "/" + TestOneActivity.thirdGranHalfLength * 2);
        infoMap.put("6粒度数量", String.valueOf(TestOneActivity.granularityNum));
        infoMap.put("7一 / 二 / 三级粒度控制滚动速度", TestOneActivity.firstGranSpeed + "/" + TestOneActivity.secondGranSpeed + "/" + TestOneActivity.thirdGranSpeed);
        infoMap.put("8标签数量", String.valueOf(TestOneActivity.labelNum));
        infoMap.put("9标签间隔", String.valueOf(TestOneActivity.labelIntervalLength));
    }

    public static void testerInfoInit(String name, int age, String phoneAge, String profession) {
        infoMap.put("1姓名", name);
        infoMap.put("2年龄", String.valueOf(age));
        infoMap.put("3使用手机的经验", phoneAge);
        infoMap.put("4职业", profession);
    }

    public static void testResultInit(int scrollingTime, float hitRate, int passedLabelNum) {
        infoMap.put("a滚动时间", String.valueOf(scrollingTime));
        infoMap.put("b命中率", String.valueOf(hitRate));
        infoMap.put("c越过的标签数", String.valueOf(passedLabelNum));
    }

    public static void dump(Context context, int testNo) {
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet(WorkbookUtil.createSafeSheetName("sheet1"));

        Row propertyRow = sheet.createRow(0);
        int pos = 0;
        for(String it: infoMap.keySet()) {
            Cell cell = propertyRow.createCell(pos++);
            cell.setCellValue(it);
        }
        Row firstRow = sheet.createRow(1);
        pos = 0;
        for(String it: infoMap.values()) {
            Cell cell = firstRow.createCell(pos++);
            cell.setCellValue(it);
        }

        String fileName = "Test" + testNo + ".xlsx";

        try {
            File fileDir = context.getFilesDir();
            File outFile = new File(fileDir, fileName);
            OutputStream stream = new FileOutputStream(outFile.getAbsoluteFile());
            book.write(stream);
            stream.flush();
            stream.close();
        }catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
