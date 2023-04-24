package com.bruno.jpa.demo.repository;

import com.bruno.jpa.demo.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento,Integer> {
}
