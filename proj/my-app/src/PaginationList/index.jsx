import React, { useState } from 'react';
import style from "./style.module.css";

const PaginationList = ({ totalPages, setPage }) => {
  // const [selectedNumber, setSelectedNumber] = useState(null);

  const pageNumbers = [...Array(totalPages).keys()]


  const handleClick = (pageNumber) => {
  
    setPage({ page: pageNumber }); // Update the setPage value with the clicked button's value
    console.log(`Clicked number: ${pageNumber}`);
  };

  return (
    <div className={style.paginationContainer} >
      {pageNumbers.map((item) => <div onClick={() => handleClick(item+1)} key={item} >{item +1}</div>)}
    </div>
  );
};

export default PaginationList;
