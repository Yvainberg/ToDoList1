import React, { useState, useEffect } from "react";
import { MdEdit, MdDone } from "react-icons/md";
import styles from "./style.module.css";
import { useContext } from "react";
import DataContext from "../../context/dataContext";
import UpdateContent from "../../pages/UpdateContent"



export default function Table({ data, handleEdit }) {
  const { setStack } = useContext(DataContext);


  return (
    <div className={styles.list_container}>
      <table className={styles.list_table}>
        <thead>
          <tr>
            <th>Name</th>
            <th>Description</th>
            <th>startdate</th>
            <th>enddate</th>
            <th>Edited</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item) => (
            <tr key={item.id}>
              <td>{item.name}</td>
              <td>{item.description}</td>
              <td>{item.startdate}</td>
              <td>{item.enddate}</td>
              <td>
                <MdEdit
                  className={styles.edit_icon}
                  onClick={() => setStack(item)
                  }
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
