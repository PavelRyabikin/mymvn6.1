package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void testCurrentStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testCurrentStationUnderLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testCurrentStationAboveLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testCurrentVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        Assertions.assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void testCurrentVolumeUnderLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testCurrentVolumeAboveLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNextStantion() {
        Radio radio = new Radio();
        radio.setCurrentStation(6);
        radio.next();
        Assertions.assertEquals(7, radio.getCurrentStation());
    }

    @Test
    public void shouldNextStantionUpperLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevStantion() {
        Radio radio = new Radio();
        radio.setCurrentStation(6);
        radio.prev();
        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevStantionlowerLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(55);
        radio.increaseVolume();
        Assertions.assertEquals(56, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeUpperLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(55);
        radio.decreaseVolume();
        Assertions.assertEquals(54, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldCreateStations() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(15);
        Assertions.assertEquals(15, radio.getCurrentStation());
    }

    @Test
    public void shouldNextStantionAfterLast() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(19);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevStationBeforeFirst() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(0);
        radio.prev();
        Assertions.assertEquals(19, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationMoreNax() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(21);
        Assertions.assertEquals(0, radio.getCurrentStation());
    }
}