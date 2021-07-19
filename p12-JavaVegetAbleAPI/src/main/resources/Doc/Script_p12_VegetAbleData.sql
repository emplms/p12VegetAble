--
-- PostgreSQL database dump
--

-- Dumped from database version 11.11
-- Dumped by pg_dump version 12.2

-- Started on 2021-07-19 21:22:45 CEST

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

--
-- TOC entry 3193 (class 0 OID 83138)
-- Dependencies: 196
-- Data for Name: adress; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.adress (adress_id, adress_email, adress_phone_number, adress_town, adress_zip_code) FROM stdin;
3	emmanuel@free.fr	102030405	Léognan	33850
5	lisa@free.fr	102030405	Léognan	33850
7	ingrid@free.fr	102030405	Léognan	33850
\.


--
-- TOC entry 3194 (class 0 OID 83146)
-- Dependencies: 197
-- Data for Name: provision; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.provision (provision_id, provision_availibility_date, provision_description, provision_name, user_id, provision_category_id) FROM stdin;
22	2021-06-16 00:00:00	2kg de courgettes	Courgette	4	1
2	2021-06-13 00:00:00	500g de tomates	Tomates	2	1
23	2021-06-16 00:00:00	Un cageot de poires	Poires	4	2
24	2021-06-18 00:00:00	3 melons	Melon	2	2
1	2021-06-15 00:00:00	Deux barquettes de fraise d'environ 500 g	Fraise	4	2
51	2021-07-04 00:00:00	Une botte de radis	Radis	2	1
56	2021-07-04 00:00:00	Une pasteque	Pastèques	2	2
58	2021-07-09 00:00:00	1kg de tomates	Tomates	4	1
61	2021-07-14 00:00:00	500 grammes d'abricots	Abricot	2	2
\.


--
-- TOC entry 3195 (class 0 OID 83154)
-- Dependencies: 198
-- Data for Name: provision_category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.provision_category (provision_category_id, provision_category_name) FROM stdin;
1	Légume
2	Fruit
\.


--
-- TOC entry 3198 (class 0 OID 83194)
-- Dependencies: 201
-- Data for Name: request; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.request (request_id, request_comment, request_date, request_status, provision_id, user_id) FROM stdin;
54	Acceptez-vous de me donner vos poires?	2021-07-04 16:18:53.331	Refusée	23	2
47	J'ai envie de melons	2021-07-01 08:29:16.404	Livrée	24	4
53	Je suis interessée par vos tomates	2021-07-04 15:44:21.569	Livrée	2	4
55	Je souhaiterai avoir vos radis	2021-07-04 18:16:07.955	Livrée	51	4
59	Je suis intéressée par vos tomates	2021-07-08 17:52:35.39	Refusée	58	2
57	Je voudrais de la pasteque svp	2021-07-08 17:48:42.278	En attente de livraison	56	4
60	Je souhaite réserver vos tomates	2021-07-14 16:05:43.308	En attente de réponse	58	2
\.


--
-- TOC entry 3196 (class 0 OID 83159)
-- Dependencies: 199
-- Data for Name: vegetableuser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vegetableuser (user_id, user_first_name, user_identifiant, user_last_name, user_password, adress_id) FROM stdin;
4	Lisa	Lisa	Plumas	$2a$10$yYsacvSL.ekllfXNsLJ5m.X5/znue3SjnIRpZQPJwaNWHXB1eTsR6	5
6	Ingrid	Ingrid	Plumas	$2a$10$BEc2ccX3h7/JHAO5cWMQSeB7srSrgYId7Vu9r14IcM8kWclmEfboe	7
2	Emmanuel	Emmanuel	Plumas	$2a$10$ESJ/2mLbbCUzu08BGAqlLuLksoGFvrIaGQAS14h4k8z1B7aJ9IHZS	3
\.


--
-- TOC entry 3204 (class 0 OID 0)
-- Dependencies: 200
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 80, true);


-- Completed on 2021-07-19 21:22:45 CEST

--
-- PostgreSQL database dump complete
--

