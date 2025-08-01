package org.example.auz.stringsort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of appointments, merge overlapping times.
 *
 * time: O(n log n)
 * space: O(n)
 */
public class MergeAppointment {

    class Appointment {
        int start;
        int end;

        public Appointment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Appointment> merge(List<Appointment> appointments) {
        List<Appointment> result = new ArrayList<>();
        if (appointments == null || appointments.size() <= 1) {
            return result;
        }

        appointments.sort(Comparator.comparing(a -> a.start));
        Appointment tmp = appointments.get(0);
        for (int i = 1; i < appointments.size(); i++) {
            Appointment cur = appointments.get(i);
            if (tmp.end < cur.start) {
                result.add(tmp);
                tmp = cur;
            } else {
                tmp.end = Math.max(tmp.end, cur.end);
            }
        }
        result.add(tmp);
        return result;
    }
}
