/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geburtstagsverwaltung;

import java.util.ArrayList;
import java.util.TreeMap;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lessi
 */
@XmlRootElement
public class BirthdayModel {
    private TreeMap<String, ArrayList<String>> birthdays = new TreeMap<>();
    
    @Override
    public String toString() {
        return birthdays.toString();
    }
    
    @XmlElement
    public TreeMap<String, String> getBirthdays() {
        TreeMap<String, String> out = new TreeMap<>();
        String names;
        
        for (String date : birthdays.keySet()) {
            names = birthdays.get(date).toString();
            out.put(date, names);
        }
        
        return out;
    }
    
    public void setBirthdays(TreeMap<String, String> birthdays) {
        TreeMap<String, ArrayList<String>> out = new TreeMap<>();
        ArrayList<String> names;
        String input;
        
        for (String date : birthdays.keySet()) {
            names = new ArrayList<>();
            input = birthdays.get(date);
            input = input.substring(1, input.length() - 1);
            String[] entries = input.split(", ");
            for (String entry : entries) {
                names.add(entry);
            }
            out.put(date, names);
        }
        this.birthdays = out;
    }
    
    @XmlTransient
    public TreeMap<String, ArrayList<String>> getBirthdaysMap() {
        return birthdays;
    }
    
    public void setBirthdaysMap(TreeMap<String, ArrayList<String>> birthdays) {
        if (birthdays == null) {
            this.birthdays = new TreeMap<>();
        } else {
            this.birthdays = birthdays;
        }
    }
}
