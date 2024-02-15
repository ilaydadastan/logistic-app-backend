ALTER TABLE shipments ALTER COLUMN tracking_id TYPE uuid USING CAST(tracking_id AS uuid);
