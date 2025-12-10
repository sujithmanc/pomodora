import React, { useEffect, useState } from "react";
import axios from "axios";

const UsersList = () => {
  const [users, setUsers] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchUsers = async () => {

      try {
        setLoading(true);
        const response = await axios.get("http://localhost:8080/api/users", {});
        setUsers(response.data);
        setLoading(false);
      } catch (err) {
        console.error("Error fetching users:", err);
        setError("Failed to load users");
        setLoading(false);
      }
    };

    fetchUsers();
  }, []);

  if (loading) {
    return <p>Loading users...</p>;
  }

  return (
    <div>
      <h2>User List</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      {users.length === 0 && !error ? (
        <p>No users found.</p>
      ) : (
        <ul>
          {users.map((user) => (
            <li key={user.id}>
              <strong>{user.username}</strong> <br />
              Email: {user.email} <br />
              Created At: {new Date(user.createdAt).toLocaleString()}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default UsersList;