package db

import (
	"github.com/gocql/gocql"
)

type Employee struct {
	CardUID     gocql.UUID
	FirstName   string
	LastName    string
	Email       string
	PhoneNumber string
	Rules       []string
}

type EmployeeRepo struct {
	session *gocql.Session
}

func NewEmployeeRepo(session *gocql.Session) *EmployeeRepo {
	return &EmployeeRepo{session: session}
}
func (e *EmployeeRepo) Insert(employee Employee) error {

	query := "INSERT INTO attendance_system.employee (card_uid, first_name, last_name, email, phone_number, rules) VALUES (?, ?, ?, ?, ?, ?)"

	err := e.session.Query(query, employee.CardUID, employee.FirstName, employee.LastName, employee.Email, employee.PhoneNumber, employee.Rules).Exec()
	return err

}

func (e *EmployeeRepo) GetAllEmployees() ([]Employee, error) {
	query := "SELECT card_uid, first_name, last_name, email, phone_number, rules FROM attendance_system.employee"

	iter := e.session.Query(query).Iter()

	var employees []Employee

	for iter.Scan() {
		var employee Employee
		if iter.Scan(&employee.CardUID, &employee.FirstName, &employee.LastName, &employee.Email, &employee.PhoneNumber, &employee.Rules) {
			employees = append(employees, employee)
		}
	}

	err := iter.Close()
	return employees, err
}

func (e *EmployeeRepo) GetByCardUID(cardUID string) (*Employee, error) {
	// Construct the SELECT query
	query := "SELECT card_uid, first_name, last_name, email, phone_number, rules FROM attendance_system.employee WHERE card_uid = ?"

	// Execute the query with the given card UID
	var employee Employee
	if err := e.session.Query(query, cardUID).Scan(&employee.CardUID, &employee.FirstName, &employee.LastName, &employee.Email, &employee.PhoneNumber, &employee.Rules); err != nil {
		return nil, err
	}

	return &employee, nil
}
