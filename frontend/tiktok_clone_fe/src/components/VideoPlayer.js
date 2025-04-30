// src/components/VideoPlayer.js
import React, { useEffect, useState } from "react";
import axios from "axios";

const VideoPlayer = () => {
  const [videos, setVideos] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios
      .get("http://localhost:8082/api/videos") // Đổi lại URL nếu khác
      .then((res) => setVideos(res.data))
      .catch((err) => {
        console.error(err);
        setError("Không thể tải danh sách video.");
      });
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h2>Danh sách video</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      {videos.length === 0 && !error && <p>Đang tải...</p>}

      {videos.map((video) => (
        <div key={video.id} style={{ marginBottom: "30px" }}>
          <h4>{video.caption}</h4>
          <h5>Upload by: {video.user.fullName}</h5>
          <video width="640" height="360" controls>
            <source src={video.videoUrl} type="video/mp4" />
            Trình duyệt của bạn không hỗ trợ thẻ video.
          </video>
          <div>
            <h5>Comment:</h5>
            <ul>
                
            </ul>
          </div>
          <hr></hr>
        </div>
      ))}
    </div>
  );
};

export default VideoPlayer;
