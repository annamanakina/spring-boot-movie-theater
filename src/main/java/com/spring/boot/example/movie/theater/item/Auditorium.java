package com.spring.boot.example.movie.theater.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

@Getter
@Setter
@EqualsAndHashCode
//@Component
public class Auditorium extends Entity implements Comparable<Auditorium>, InitializingBean {
    private String name;
    private int numberOfSeats;
    private String setOfSeats;
    private Set<Integer> vipSeats;

    //private boolean isAvailable;
    // private boolean[] timeSlots = new boolean[5]; todo

    public Auditorium(int id, String name, int numberOfSeats, String vipSeats) {
        super(id);
        //System.out.println("vipSeats" + vipSeats);  //todo to clarify
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.setOfSeats = vipSeats;
    }

    public Set<Integer> getAllSeats() {
        return IntStream.range(1, numberOfSeats+1).boxed().collect(Collectors.toSet());
    }

    public Set<Integer> getVipSeats() {
        return vipSeats;
    }

    /**
     * @author Yuriy_Tkach
     *
     * Counts how many vip seats are there in supplied <code>seats</code>
     *
     * @param seats
     *            Seats to process
     * @return number of vip seats in request
     */
    //don't understand what purpose (usage) was this method created for by @author
    public long countVipSeats(Collection<Integer> seats) {
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + super.getId()+
                ", name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }

    @Override
    public int compareTo(Auditorium object) {
        return this.getName().compareTo(object.getName());
    }

    private void initVipSeats(String vipSeats){
        //todo to clarify
        //System.out.println("string vipSeats"+vipSeats);
        this.vipSeats = Arrays.stream(vipSeats.split(","))
                .map(Integer::parseInt).collect(toSet());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initVipSeats(this.setOfSeats);
        this.vipSeats.forEach(System.out::print);
        //System.out.println("afterPropertiesSet initVipSeats is initialized");
    }
}
