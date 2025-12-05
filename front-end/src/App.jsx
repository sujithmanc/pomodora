import React, { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const [data, setData] = useState(null);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchData = async () => {
      try {
        // Async call with axios
        const response = await axios.get("http://172.31.18.191:8080/hi");
        setData(response.data);
      } catch (err) {
        console.error("Error fetching API:", err);
        setError("Failed to fetch data. Please try again later.");
      }
    };

    fetchData();
  }, []);

  if (error) {
    return <p style={{ color: "red" }}>{error}</p>;
  }

  if (!data) {
    return <p>Loading...</p>;
  }

  return (
    <div style={{ fontFamily: "Arial, sans-serif", padding: "20px" }}>
      <h1>API Response</h1>
      <ul style={{ listStyle: "none", padding: 0 }}>
        <li><strong>Message:</strong> {data.Message}</li>
        <li><strong>Remote IP:</strong> {data.RemoteIP}</li>
        <li><strong>Local IP:</strong> {data.LocalIP}</li>
        <li><strong>Local Port:</strong> {data.LocalPort}</li>
        <li><strong>Remote Port:</strong> {data.RemotePort}</li>
        <li><strong>Server Name:</strong> {data.ServerName}</li>
        <li><strong>Request URI:</strong> {data.RequestURI}</li>
        <li><strong>Method:</strong> {data.Method}</li>
        <li><strong>Protocol:</strong> {data.Protocol}</li>
        <li><strong>Timestamp:</strong> {data.Timestamp}</li>
      </ul>
    </div>
  );
}

export default App;