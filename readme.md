metrics地址
http://localhost:7005/actuator/metrics

prometheus端点地址
http://localhost:7005/actuator/prometheus

prometheus监控配置
  - job_name: 'java-web-exporter'
    scrape_interval: 15s
    static_configs:
    - targets: ['localhost:7005']
      metrics_path: '/actuator'
      labels:
        instance: prometheus-test