CREATE TABLE issue_detail (
    ID INT PRIMARY KEY     NOT NULL,
	site_id INTEGER,
	issue_key TEXT COLLATE pg_catalog."default",
	alert_type TEXT COLLATE pg_catalog."default",
	"alert_resolution " TEXT COLLATE pg_catalog."default",
	"duration_start " DATE,
	"duration_end " DATE,
	org_id INTEGER
);