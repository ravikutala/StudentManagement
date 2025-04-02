package com.student.management.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="students")
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="student_id")
private int studentId;
@Column(name="student_name")
private String studentName;
@Column(name="student_class")
private String studentClass;
@Column(name="student_section")
private String studentSection;
@Column(name="year_fee")
private int yearFee;
@Column(name="fee-paid")
private int feePaid;
@Column(name="balance_fee")
private int balanceFee;
}
