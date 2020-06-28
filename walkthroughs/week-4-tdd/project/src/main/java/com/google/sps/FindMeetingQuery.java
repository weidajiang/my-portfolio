// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the Liceunse.

package com.google.sps;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public final class FindMeetingQuery {

  public Collection<TimeRange> query(Collection<Event> events, MeetingRequest request) {
    //throw new UnsupportedOperationException("TODO: Implement this method.");

    Collection<String> attendees = request.getAttendees();
    long duration = request.getDuration();

    // no attendees case, Expected :[Range: [0, 1440)]
    if(attendees.isEmpty()){

      return Arrays.asList(TimeRange.WHOLE_DAY);

    }
    // during over 24hours , Expected :[Range: [0, 1440)]
    if (duration> TimeRange.WHOLE_DAY.duration()){
      return Arrays.asList();
    }

    Iterator<Event> it = events.iterator();
    List<TimeRange> resultList = new ArrayList<TimeRange>();

    int startTime = TimeRange.START_OF_DAY;

    while (it.hasNext()) {
      Event e = it.next();
      int eachDuration = e.getWhen().duration();
      int endTime = e.getWhen().end();
      TimeRange t = TimeRange.fromStartEnd(startTime, e.getWhen().start(),false);
      startTime = endTime;
      resultList.add(t);
    }

    TimeRange t = TimeRange.fromStartEnd(startTime, TimeRange.END_OF_DAY,true);

    resultList.add(t);
    return resultList;


  }
}
