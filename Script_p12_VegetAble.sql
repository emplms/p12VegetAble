--
-- PostgreSQL database dump
--

-- Dumped from database version 11.11
-- Dumped by pg_dump version 12.2

-- Started on 2021-07-19 21:19:55 CEST

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

--
-- TOC entry 196 (class 1259 OID 83138)
-- Name: adress; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.adress (
    adress_id bigint NOT NULL,
    adress_email character varying(255),
    adress_phone_number integer NOT NULL,
    adress_town character varying(255),
    adress_zip_code integer NOT NULL
);


ALTER TABLE public.adress OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 83167)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 83146)
-- Name: provision; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.provision (
    provision_id bigint NOT NULL,
    provision_availibility_date timestamp without time zone,
    provision_description character varying(255),
    provision_name character varying(255),
    user_id bigint,
    provision_category_id bigint
);


ALTER TABLE public.provision OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 83154)
-- Name: provision_category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.provision_category (
    provision_category_id bigint NOT NULL,
    provision_category_name character varying(255)
);


ALTER TABLE public.provision_category OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 83194)
-- Name: request; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.request (
    request_id bigint NOT NULL,
    request_comment character varying(255),
    request_date timestamp without time zone,
    request_status character varying(255),
    provision_id bigint,
    user_id bigint
);


ALTER TABLE public.request OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 83159)
-- Name: vegetableuser; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vegetableuser (
    user_id bigint NOT NULL,
    user_first_name character varying(255),
    user_identifiant character varying(255),
    user_last_name character varying(255),
    user_password character varying(255),
    adress_id bigint
);


ALTER TABLE public.vegetableuser OWNER TO postgres;

--
-- TOC entry 3058 (class 2606 OID 83145)
-- Name: adress adress_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adress
    ADD CONSTRAINT adress_pkey PRIMARY KEY (adress_id);


--
-- TOC entry 3062 (class 2606 OID 83158)
-- Name: provision_category provision_category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provision_category
    ADD CONSTRAINT provision_category_pkey PRIMARY KEY (provision_category_id);


--
-- TOC entry 3060 (class 2606 OID 83153)
-- Name: provision provision_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provision
    ADD CONSTRAINT provision_pkey PRIMARY KEY (provision_id);


--
-- TOC entry 3066 (class 2606 OID 83201)
-- Name: request request_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.request
    ADD CONSTRAINT request_pkey PRIMARY KEY (request_id);


--
-- TOC entry 3064 (class 2606 OID 83166)
-- Name: vegetableuser vegetableuser_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vegetableuser
    ADD CONSTRAINT vegetableuser_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3071 (class 2606 OID 83207)
-- Name: request fk8rlav308kj9ttd02uflj113pc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.request
    ADD CONSTRAINT fk8rlav308kj9ttd02uflj113pc FOREIGN KEY (user_id) REFERENCES public.vegetableuser(user_id);


--
-- TOC entry 3070 (class 2606 OID 83202)
-- Name: request fki3jppym0vwe5r0fqba6wtqhwi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.request
    ADD CONSTRAINT fki3jppym0vwe5r0fqba6wtqhwi FOREIGN KEY (provision_id) REFERENCES public.provision(provision_id);


--
-- TOC entry 3068 (class 2606 OID 83184)
-- Name: provision fki4i0lo5dg0cks8y0c9enqstco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provision
    ADD CONSTRAINT fki4i0lo5dg0cks8y0c9enqstco FOREIGN KEY (provision_category_id) REFERENCES public.provision_category(provision_category_id);


--
-- TOC entry 3067 (class 2606 OID 83174)
-- Name: provision fkns9xtiona4k8nkyci4w4u8pue; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provision
    ADD CONSTRAINT fkns9xtiona4k8nkyci4w4u8pue FOREIGN KEY (user_id) REFERENCES public.vegetableuser(user_id);


--
-- TOC entry 3069 (class 2606 OID 83189)
-- Name: vegetableuser fkp24nnqo82p9u7cy4yp4vdoydp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vegetableuser
    ADD CONSTRAINT fkp24nnqo82p9u7cy4yp4vdoydp FOREIGN KEY (adress_id) REFERENCES public.adress(adress_id);


-- Completed on 2021-07-19 21:19:55 CEST

--
-- PostgreSQL database dump complete
--

