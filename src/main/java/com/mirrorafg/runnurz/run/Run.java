package com.mirrorafg.runnurz.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime complatedOn,
    @Positive
    Integer miles,
    Location location
) {
    public Run{
        if(!complatedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Complated on is must be AfterOn");
        }
    }
    
}

// public class Run {
    
    // private Integer id;
    // private String title;
    // private LocalDateTime startedOn;
    // private LocalDateTime complatedOn;
    // private Integer miles;
    // private Location location;


//     public Run(Integer id, String title, LocalDateTime startedOn, LocalDateTime complatedOn, Integer miles,
//             Location location) {
//         this.id = id;
//         this.title = title;
//         this.startedOn = startedOn;
//         this.complatedOn = complatedOn;
//         this.miles = miles;
//         this.location = location;
//         if(!complatedOn.isAfter(startedOn)){
//             throw new IllegalArgumentException("Complated on must be after Started on");
//         }
//     }

//     public Integer getId() {
//         return id;
//     }

//     public void setId(Integer id) {
//         this.id = id;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public LocalDateTime getStartedOn() {
//         return startedOn;
//     }

//     public void setStartedOn(LocalDateTime startedOn) {
//         this.startedOn = startedOn;
//     }

//     public LocalDateTime getComplatedOn() {
//         return complatedOn;
//     }

//     public void setComplatedOn(LocalDateTime complatedOn) {
//         this.complatedOn = complatedOn;
//     }

//     public Integer getMiles() {
//         return miles;
//     }

//     public void setMiles(Integer miles) {
//         this.miles = miles;
//     }

//     public Location getLocation() {
//         return location;
//     }

//     public void setLocation(Location location) {
//         this.location = location;
//     }

//     @Override
//     public boolean equals (Object o){
//         if(this == o )  return true;
//         if(o==null || getClass() != o.getClass() ) return false;

//         Run run = (Run) o;
//         return Objects.equals(o, run.id) && Objects.equals(title, run.title) && Objects.equals(startedOn, run.startedOn) 
//         && Objects.equals(complatedOn, run.complatedOn) && Objects.equals(miles, run.miles) && Objects.equals(location, run.location);

//     }

//     @Override
//     public int hashCode(){
//         return Objects.hash(id, title, startedOn, complatedOn, miles, location);
//     }

//     @Override
//     public String toString(){
//         return "Run{"+
//                 "id="+id+
//                 ", title="+title+'\''+
//                 ", startedOn="+startedOn+
//                 ", complatedOn="+complatedOn+
//                 ", miles="+miles+
//                 ", location="+location+
//                 '}';
//     }


// }
