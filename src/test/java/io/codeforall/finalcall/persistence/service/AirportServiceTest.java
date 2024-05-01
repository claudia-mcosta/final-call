package io.codeforall.finalcall.persistence.service;

import io.codeforall.finalcall.persistence.dao.AirportDao;
import io.codeforall.finalcall.service.AirportService;
import io.codeforall.finalcall.service.AirportServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class AirportServiceTest {

    private AirportService airportService;
    private AirportDao airportDao;

    @Before
    public void setup() {
        airportService = new AirportServiceImpl();
        airportDao = mock(AirportDao.class);
    }

    @Test
    public void testGet() {

    }

}
