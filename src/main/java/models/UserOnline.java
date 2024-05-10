package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserOnline {
	private LocalDate startSession;
	private LocalDate endSession;
}