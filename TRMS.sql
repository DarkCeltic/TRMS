--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7
-- Dumped by pg_dump version 11.7

-- Started on 2020-03-05 13:17:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 17195)
-- Name: employee_levels; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_levels (
    level_type numeric NOT NULL,
    level_description character varying(50) NOT NULL
);


ALTER TABLE public.employee_levels OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 17188)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    firstname character varying(20) NOT NULL,
    lastname character varying(20) NOT NULL,
    username character varying(20) NOT NULL,
    password character varying(20) NOT NULL,
    employee_level numeric NOT NULL,
    reimbursement_amount numeric DEFAULT 1000 NOT NULL
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 17207)
-- Name: event_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event_type (
    event_id numeric NOT NULL,
    event_type character varying(30)
);


ALTER TABLE public.event_type OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 17201)
-- Name: events; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.events (
    event_description character varying(20) NOT NULL,
    price numeric NOT NULL,
    city character varying(20) NOT NULL,
    state character varying(20) NOT NULL,
    zip_code numeric NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    start_time time without time zone NOT NULL,
    end_time time without time zone NOT NULL,
    grading_format_id numeric NOT NULL,
    event_type_id numeric NOT NULL,
    justification character varying(50) NOT NULL,
    username character varying(20) NOT NULL,
    final_grade character varying(50)
);


ALTER TABLE public.events OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 17213)
-- Name: grading_format; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.grading_format (
    grading_format_id numeric NOT NULL,
    grading_format_description character varying(20) NOT NULL
);


ALTER TABLE public.grading_format OWNER TO postgres;

--
-- TOC entry 2839 (class 0 OID 17195)
-- Dependencies: 197
-- Data for Name: employee_levels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_levels (level_type, level_description) FROM stdin;
1	Warehouse Employee
2	Warehouse Direct Manager
3	Warehouse Head Manager
4	Paper Sales Employee(BenCO)
5	Paper Sales Direct Manager(BenCO)
6	Paper Sales Head Manager(BenCO)
\.


--
-- TOC entry 2838 (class 0 OID 17188)
-- Dependencies: 196
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employees (firstname, lastname, username, password, employee_level, reimbursement_amount) FROM stdin;
Roy	Anderson	Rand	ware	1	1000
Lonny 	Collins	Lcol	ware	2	1000
Madge 	Madsen	Mmad	ware	1	1000
Darryl	Philbin	Dphi	ware	3	1000
Dwight 	Schrute	Dsch	sale	4	1000
Pam 	Beesly	Pbee	sale	4	1000
Andy 	Bernard	Aber	sale	4	1000
Jim 	Halpert	Jhal	sale	5	1000
Michael 	Scott	Msco	sale	6	1000
\.


--
-- TOC entry 2841 (class 0 OID 17207)
-- Dependencies: 199
-- Data for Name: event_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.event_type (event_id, event_type) FROM stdin;
1	University Course
2	Seminar
3	Certification Prep 
4	Certification
5	Technical Training
6	Other
\.


--
-- TOC entry 2840 (class 0 OID 17201)
-- Dependencies: 198
-- Data for Name: events; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.events (event_description, price, city, state, zip_code, start_date, end_date, start_time, end_time, grading_format_id, event_type_id, justification, username, final_grade) FROM stdin;
\.


--
-- TOC entry 2842 (class 0 OID 17213)
-- Dependencies: 200
-- Data for Name: grading_format; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.grading_format (grading_format_id, grading_format_description) FROM stdin;
1	Letter Grade
2	Pass/Fail
3	Presentation
\.


--
-- TOC entry 2708 (class 2606 OID 17220)
-- Name: employee_levels employee_levels_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_levels
    ADD CONSTRAINT employee_levels_pk PRIMARY KEY (level_type);


--
-- TOC entry 2706 (class 2606 OID 17222)
-- Name: employees employees_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pk PRIMARY KEY (username);


--
-- TOC entry 2710 (class 2606 OID 17236)
-- Name: event_type event_type_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_type
    ADD CONSTRAINT event_type_pk PRIMARY KEY (event_id);


--
-- TOC entry 2712 (class 2606 OID 17234)
-- Name: grading_format grading_format_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grading_format
    ADD CONSTRAINT grading_format_pk PRIMARY KEY (grading_format_id);


--
-- TOC entry 2713 (class 2606 OID 17228)
-- Name: employees employees_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_fk FOREIGN KEY (employee_level) REFERENCES public.employee_levels(level_type);


--
-- TOC entry 2715 (class 2606 OID 17242)
-- Name: events events_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_fk FOREIGN KEY (event_type_id) REFERENCES public.event_type(event_id);


--
-- TOC entry 2714 (class 2606 OID 17237)
-- Name: events events_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_fk_1 FOREIGN KEY (grading_format_id) REFERENCES public.grading_format(grading_format_id);


--
-- TOC entry 2716 (class 2606 OID 17247)
-- Name: events events_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_fk_2 FOREIGN KEY (username) REFERENCES public.employees(username);


-- Completed on 2020-03-05 13:17:01

--
-- PostgreSQL database dump complete
--

