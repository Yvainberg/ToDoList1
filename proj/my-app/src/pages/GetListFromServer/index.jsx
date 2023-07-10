import React, { useState, useEffect } from "react";
import RequestAxios from "../../function/RequestAxios";
import Table from "../../compotes/Table";
import style from "./style.module.css";
import { useContext } from 'react'
import PaginationList from "../../PaginationList"
import DataContext from "../../context/dataContext";


export default function GetListFromServer() {
// useContext for spinner
  const {loading, setLoading} = useContext(DataContext);
  const [data, setData] = useState([]);
  const [page, setPage] = useState({page:1})
  const [totalPages, setTotalPages] = useState();

  const fetchData = async () => {
    try {
      setLoading(true);
      // const response = await RequestAxios("/todolist/getAll", "GET");
      console.log("page : "+page.page);
      const response = await RequestAxios("/todolist/getItemPages", "POST",page);
      console.log(response.data);
      setData(response.data);
      setLoading(false);
     
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchData();
  }, [page,loading]);

  const totalPage = async () => {
      try {
          setLoading(true);
          const response = await RequestAxios("/todolist/TotalPages", "GET");
          setTotalPages(response.data)
          setLoading(false);
      } catch (error) {
          console.log(error);
      }
  };
  useEffect(() => {
      console.log(totalPages);
      totalPage();
  }, [totalPages,loading])

  return (
    <div>
      <Table data={data}   />
      <PaginationList totalPages={totalPages} setPage={setPage} />
    </div>
  );
}
