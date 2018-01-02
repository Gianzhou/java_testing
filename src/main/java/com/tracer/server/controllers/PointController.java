package com.tracer.server.controllers;

import com.tracer.server.repositories.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PointController {
    @Autowired
    private PointRepository pointRepository;
}
