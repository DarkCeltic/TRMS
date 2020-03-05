# TRMS

Tuition Reimbursement Management System (TRMS)

TRMS Overview
	The purpose of TRMS is to provide a system that encourages quality knowledge growth relevant to an individual’s expertise.   Currently, TRMS provides reimbursements for university courses, seminars, certification preparation classes, certifications, and technical training.  The decision has been made to develop a BPM solution for this system to improve the timeliness and accuracy of approvals.  The current system relies solely on email communication, requiring manual lookups of available funds and is error-prone due to inbox clutter 	and incorrect routing of tasks.  Furthermore, there is no way to record and report on reimbursements awarded, and so the company has no way to identify highly-invested courses that could be developed to be offered in-house.

Business Rules
	Each employee is allowed to claim up to $1000 in tuition reimbursement a year.  The amount available to an employee is reset on the new year.  Event types have different standard reimbursement coverage: University Courses 80%, Seminars 60%, Certification Preparation Classes 75%, Certification 100%, Technical Training 90%, Other 30%.  After a BenCo has approved a reimbursement, the reimbursement is pending until a passing grade or presentation over the event is provided.  The monetary amount available for an employee to reimburse is defined by the following equation: AvailableReimburstment = TotalReimburstment ($1000) – PendingReimburstments – AwardedReimburstments.  If the projected reimbursement for an event exceeds the available reimbursement amount, it is adjusted to the amount available.  Reimbursements do not cover course materials such as books.

Complete the Tuition Reimbursement Form
	All Employees must complete the Tuition Reimbursement form one week prior to the start of the event.  This form must collect (required): basic employee information; date, time, location, description, cost, grading format, and type of event; work-related justification.  The employee can optionally include: event-related attachments of pdf, png, jpeg, txt, or doc file type, attachments of approvals already provided of .msg (Outlook Email File) file type and type of approval, work time that will be missed.  The projected reimbursement should be provided as a read-only field.

Business Rules
	Grading formats are pulled from a reference table.  Certain grading formats require the employee to perform a presentation to management after the event’s completion and prior to awarded reimbursement.  A passing grade is needed for reimbursement otherwise.  Employee must provide the passing grade cutoff for the course, or choose to use a default passing grade if unknown.  If an employee provides an approval email, that approval step is skipped (cannot skip BenCo Approval).  If the course is < 2 weeks from beginning, the request is marked urgent.
Direct Supervisor Approval
The direct supervisor must provide approval for Tuition Reimbursement.  The Direct Supervisor can request additional information from the employee before approval. 

Business Rules
	If denied, the Direct Supervisor must provide a reason.  If the direct supervisor is also a department head, then the department head approval is skipped.  If the direct supervisor does not complete this task in a timely matter, the request is auto-approved. 

Department Head Approval
The department head must provide approval for Tuition Reimbursement.  The Department Head can request additional information from the employee or direct supervisor before approval.

Business Rules
If the Department Head does not complete this task in a timely matter, the request is auto-approved.

Benefits Coordinator Approval
	The BenCo must provide approval for Tuition Reimbursement.   This stage is not skippable for any reason.  The BenCo can request additional information from the employee, direct supervisor, or department head before approval. The BenCo has the ability to alter the reimbursement amount.

Business Rules
	If the BenCo changes the reimbursement amount, the Employee should be notified and given the option to cancel the request.  If the BenCo does not approve in a timely matter, an escalation email should be sent to the BenCo’s direct supervisor.  The BenCo is allowed to award an amount larger than the amount available for the employee.  The BenCo must provide reason for this, and the reimbursement must be marked as exceeding available funds for reporting purposes.

Grade/Presentation Upload
	Upon completion of the event, the employee should attach either the Grade or Presentation as appropriate.  After upload of a grade, the BenCo must confirm that the grade is passing.  After upload of a presentation, the direct manager must confirm that the presentation was satisfactory and presented to the apprpriate parties.  Upon confirmation, the amount is awarded to the requestor.

Business Rules
Only interested parties should be able to access the grades/presentations.  Interested parties include the requestor and approvers.  

Employee
As an Employees I must complete the Tuition Reimbursement form one week prior to the start of the event
As an Employee I must provide the passing grade cutoff for the course, or choose to use a default passing grade if unknown
As an employee I can provide an approval email
As an employee I can provide my grade or presentation Upon completion of the event
As an employee I can fill out the form with: basic employee information; date, time, location, description, cost, grading format, and type of event; work-related justification. 
As an employee I can include: event-related attachments of pdf, png, jpeg, txt, or doc file type, attachments of approvals already provided of .msg (Outlook Email File) file type and type of approval, work time that will be missed.  

System
As the System I can calculate the following: University Courses 80%, Seminars 60%, Certification Preparation Classes 75%, Certification 100%, Technical Training 90%, Other 30%.
As the system I can calculate the AvailableReimburstment = TotalReimburstment ($1000) – PendingReimburstments – AwardedReimburstments
As the system If the course is < 2 weeks from beginning, the request is marked urgent.
 As the system I will auto-approve a request if the direct supervisor does not in a timely manner
as the system I will award the amount to the employee once the confirmation is confirmed
As the system i Only allow interested parties access to the grades/presentations.
as the system i allow Each employee $1000 in tuition reimbursement a year.
As the  system if an employee provides a confirmation email the approval step is skipped for manager
As the system I should notify the Employee and allow them to cancel their request if there reimbursement amount is changed.  

Supervisor
as The direct supervisor I must provide approval for Tuition Reimbursement.  
As The Direct Supervisor I can request additional information from the employee before approval. 
As the  direct manager I must confirm that the presentation was satisfactory and presented to the appropriate parties.

BenCO
As the BenCo I must provide approval for Tuition Reimbursement.   
As the BenCo I can request additional information from the employee, direct supervisor, or department head before approval. 
As the BenCo I have the ability to alter the reimbursement amount.
As the BenCo I can change the reimbursement amount 
As the BenCo I am allowed to award an amount larger than the amount available for the employee.
As the BenCo I must confirm that the grade is passing



