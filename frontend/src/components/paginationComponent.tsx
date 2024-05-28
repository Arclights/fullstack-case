import { Pagination } from "react-bootstrap";

 export default ({
    pageNumber,
    totalNumberOfPages,
    setPage,
  }: {
    pageNumber: number;
    totalNumberOfPages: number;
    setPage: (pageNumber: Number) => void;
  }) => {
    const isAtFirstPage = pageNumber === 0;
    const isAtLastPage = pageNumber === totalNumberOfPages - 1;
    const middleButtons =
      isAtFirstPage || isAtLastPage
        ? [<Pagination.Ellipsis disabled={true} />]
        : [
            <Pagination.Ellipsis disabled={true} />,
            <Pagination.Item active={true}>{pageNumber}</Pagination.Item>,
            <Pagination.Ellipsis disabled={true} />,
          ];
    return (
      <Pagination>
        <Pagination.Prev
          disabled={isAtFirstPage}
          onClick={() => setPage(pageNumber - 1)}
        />
        <Pagination.Item active={isAtFirstPage} onClick={() => setPage(0)}>
          {0}
        </Pagination.Item>
        {middleButtons}
        <Pagination.Item
          active={isAtLastPage}
          onClick={() => setPage(totalNumberOfPages - 1)}
        >
          {totalNumberOfPages - 1}
        </Pagination.Item>
        <Pagination.Next
          disabled={isAtLastPage}
          onClick={() => setPage(pageNumber + 1)}
        />
      </Pagination>
    );
  };