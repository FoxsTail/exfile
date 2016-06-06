/*
package ua.alice.entity;

import org.springframework.beans.factory.annotation.Autowired;
import ua.alice.repository.SubdivisionJpaRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * Created by Лис on 05.06.2016.
 *//*

public class Test {
    @Autowired
   static private SubdivisionJpaRepository subdivisionJpaRepository;
    public static void main(String[] args) {

        List<Subdivision> subdivisions = subdivisionJpaRepository.findAll();
        Map<Integer, String> subMap = new HashMap<>();
        for (Subdivision s : subdivisions) {
            subMap.put(s.getIds(), s.getName());
        }

        Map<Integer, String> depFS = new HashMap<>();
        Map<Integer, String> depFS2 = new HashMap<>();

        for (Department d : subdivisions.get(0).getDepartments()) {
            depFS.put(d.getIdd(), d.getName());
        }
        for (Department d : subdivisions.get(1).getDepartments()) {
            depFS2.put(d.getIdd(), d.getName());
        }

        Map<Integer, Map<Integer, String>> subPerDep = new HashMap<>();
        subPerDep.put(subdivisions.get(0).getIds(), depFS);
        subPerDep.put(subdivisions.get(1).getIds(), depFS2);

        for(Map.Entry<Integer, Map<Integer, String>> map: subPerDep.entrySet()){
            System.out.println(map);
        }
    }
}
*/
