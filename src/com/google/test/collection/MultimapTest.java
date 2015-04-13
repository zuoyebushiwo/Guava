package com.google.test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;

public class MultimapTest {
	Map<String, List<StudentScore>> StudentScoreMap = new HashMap<String, List<StudentScore>>();

	@Test
	public void testStudentScore() {

		for (int i = 10; i < 20; i++) {
			StudentScore studentScore = new StudentScore();
			studentScore.CourseId = 1001 + i;
			studentScore.score = 100 - i;
			addStudentScore("peida", studentScore);
		}

//		System.out.println("StudentScoreMap:" + StudentScoreMap.size());
//		System.out.println("StudentScoreMap:"
//				+ StudentScoreMap.containsKey("peida"));
//
//		System.out.println("StudentScoreMap:"
//				+ StudentScoreMap.containsKey("jerry"));
//		System.out.println("StudentScoreMap:" + StudentScoreMap.size());
//		System.out.println("StudentScoreMap:"
//				+ StudentScoreMap.get("peida").size());

		List<StudentScore> StudentScoreList = StudentScoreMap.get("peida");
		if (StudentScoreList != null && StudentScoreList.size() > 0) {
			for (StudentScore stuScore : StudentScoreList) {
//				System.out.println("stuScore one:" + stuScore.CourseId
//						+ " score:" + stuScore.score);
			}
		}
	}

	public void addStudentScore(final String stuName,
			final StudentScore studentScore) {
		List<StudentScore> stuScore = StudentScoreMap.get(stuName);
		if (stuScore == null) {
			stuScore = new ArrayList<StudentScore>();
			StudentScoreMap.put(stuName, stuScore);
		}
		stuScore.add(studentScore);
	}

//	@Test
//	public void teststuScoreMultimap() {
//		Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap
//				.create();
//		for (int i = 10; i < 20; i++) {
//			StudentScore studentScore = new StudentScore();
//			studentScore.CourseId = 1001 + i;
//			studentScore.score = 100 - i;
//			scoreMultimap.put("peida", studentScore);
//		}
//		System.out.println("scoreMultimap:" + scoreMultimap.size());
//		System.out.println("scoreMultimap:" + scoreMultimap.keys());
//	}

	@Test
	public void teststuScoreMultimap() {
		Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap
				.create();
		for (int i = 10; i < 20; i++) {
			StudentScore studentScore = new StudentScore();
			studentScore.CourseId = 1001 + i;
			studentScore.score = 100 - i;
			scoreMultimap.put("peida", studentScore);
		}
		System.out.println("scoreMultimap:" + scoreMultimap.size());
		System.out.println("scoreMultimap:" + scoreMultimap.keys());

		Collection<StudentScore> studentScore = scoreMultimap.get("peida");
		studentScore.clear();
		StudentScore studentScoreNew = new StudentScore();
		studentScoreNew.CourseId = 1034;
		studentScoreNew.score = 67;
		studentScore.add(studentScoreNew);

		System.out.println("scoreMultimap:" + scoreMultimap.size());
		System.out.println("scoreMultimap:" + scoreMultimap.keys());
	}
	
	/**
	 * Äæ×ªMapµÄkeyºÍvalue
	 * @param <S>
	 * @param <T>
	 * @param map
	 * @return
	 */
	public static <S,T> Map<T,S> getInverseMap(Map<S,T> map) {
	    Map<T,S> inverseMap = new HashMap<T,S>();
	    for(Entry<S,T> entry: map.entrySet()) {
	        inverseMap.put(entry.getValue(), entry.getKey());
	    }
	    return inverseMap;
	}
	
//	@Test
	public void BimapTest(){
	    BiMap<Integer,String> logfileMap = HashBiMap.create();
	    logfileMap.put(1,"a.log");
	    logfileMap.put(2,"b.log");
	    logfileMap.put(3,"c.log");
	    logfileMap.put(4,"d.log");
	    logfileMap.put(5,"d.log");
	}
	
	@Test
    public void TableTest(){
        Table<String, Integer, String> aTable = HashBasedTable.create();

        for (char a = 'A'; a <= 'C'; ++a) {
            for (Integer b = 1; b <= 3; ++b) {
                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
            }
        }

        System.out.println(aTable.column(2));
        System.out.println(aTable.row("B"));
        System.out.println(aTable.get("B", 2));

        System.out.println(aTable.contains("D", 1));
        System.out.println(aTable.containsColumn(3));
        System.out.println(aTable.containsRow("C"));
        System.out.println(aTable.columnMap());
        System.out.println(aTable.rowMap());

        System.out.println(aTable.remove("B", 3));
    }
	
}

class StudentScore {
	int CourseId;
	int score;
}